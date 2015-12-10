package com.cquacmer.controller;


import com.cquacmer.model.User;
import com.cquacmer.service.ILoginService;
import com.cquacmer.service.IUserService;
import com.cquacmer.util.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by admin on 2015/11/20.
 */

@Controller
@RequestMapping("/user")
public class LoginController {
    @Resource
    private ILoginService loginService;
    @Resource
    private IUserService userService;
    @RequestMapping(value="/login")
    public ModelAndView login(HttpServletRequest request,HttpSession httpSession) throws Exception{
        //如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        //根据shiro返回的异常类路径判断，抛出指定异常信息
        if(exceptionClassName!=null){
            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
                //最终会抛给异常处理器
                return new ModelAndView("/login","loginError","用户不存在");
            } else if (IncorrectCredentialsException.class.getName().equals(
                    exceptionClassName)) {
                return new ModelAndView("/login","loginError","用户名密码错误");
            } else if("CodeError".equals(exceptionClassName)){
                return new ModelAndView("/login","loginError","验证码错误");
            }else if(ExcessiveAttemptsException.class.getName().equals(exceptionClassName)) {
                return new ModelAndView("/login","loginError","尝试次数过多，稍后重试");
            }else{
                return new ModelAndView("/login","loginError","登陆失败");
            }
        }
        System.out.println("loginHandle:");
        Subject subject=SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            User user=userService.findByEmail( (String)subject.getPrincipal());
            request.getSession().setAttribute("user", user);
            System.out.println("logined:"+subject.getPrincipal());
            return new ModelAndView("/user/profile","user",user);
        }

        return new ModelAndView("/login");
           /* String code=(String)request.getParameter("code");
            if(code==null || !code.toLowerCase().equals(httpSession.getAttribute("code").toString().toLowerCase()) ){
                return new ModelAndView("/login","loginError","验证码错误");
            }
            UsernamePasswordToken token=new UsernamePasswordToken((String) request.getParameter("email"),(String) request.getParameter("password"));
            if(request.getParameter("rememberMe")!=null)
                token.setRememberMe(true);
            else
                token.setRememberMe(false);
            Subject subject= SecurityUtils.getSubject();
            try{
                subject.login(token);
            }catch(UnknownAccountException e) {
                return new ModelAndView("/login","loginError","用户不存在");
            }catch(IncorrectCredentialsException e) {
                return new ModelAndView("/login","loginError","用户名密码错误");
            }catch(ExcessiveAttemptsException e){
                return new ModelAndView("/login","loginError","尝试次数过多，稍后重试");
            }
            catch (Exception e){
                return new ModelAndView("/login","loginError","验证码错误");
            }
            User user=userService.findByEmail((String) request.getParameter("email"));
            if(user==null) System.out.println("null"); else System.out.println("not null");
            httpSession.setAttribute("user",user);

        subject.getSession().setAttribute("user",user);
            return new ModelAndView("/user/profile","user",user);*/
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ModelAndView register(User u,String code,HttpSession httpSession){
        if(code.isEmpty() || !code.toLowerCase().equals(httpSession.getAttribute("code").toString().toLowerCase()) )
        {
            return new ModelAndView("/register","registerError","验证码错误");
        }
        User temp=userService.findByEmail(u.getEmail());
        if(temp!=null){

            return new ModelAndView("/register","registerError","邮箱已经注册");
        }
            u.setSalt(StringUtils.getRandomString(6));
            Md5Hash md5=new Md5Hash(u.getPassword(),u.getSalt(),2);
            u.setPassword(md5.toString());
            User user = loginService.register(u);
            if (user!=null) httpSession.setAttribute("user",user);
            return new ModelAndView("/user/profile", "user", loginService.register(u));
    }
    @RequestMapping(value="/logout")
    public String logout(HttpSession httpSession,Model model){
        httpSession.removeAttribute("user");
        Subject subject= SecurityUtils.getSubject();
        subject.logout();
        return "/index";
    }
}
