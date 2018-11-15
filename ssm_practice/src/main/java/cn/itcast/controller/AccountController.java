package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import cn.itcast.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 帐户web
 */

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model,HttpServletRequest request){
        System.out.println("表现层：查询所有账户...");
        List<Account> list = accountService.findAll();
        request.getSession().setAttribute("list",list);
        // 调用service的方法
        return "list";
    }

    /**
     * 保存
     * @return
     */
    @RequestMapping("/save")
    public void save(Account account,HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        accountService.saveAccount(account);
        System.out.println("表现层：保存账户...");
        response.sendRedirect("findAll");
    }



}
