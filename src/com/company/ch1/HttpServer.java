package com.company.ch1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by jyan on 2018/8/9.
 */
public class HttpServer {

    private static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";

    private static final String SHUTDOWN_COMMAND = "shutdown";

    public void await() {
        // 初始化ServerSocket，监听8080端口，创建新Socket对象用于和客户端沟通
        // 具体的，从Socket中获取inputstream outputstream
        // inputstream传入request对象，request对象负责从inputstream中读取数据并解析
        // outputstream传入response对象，供向客户端写入数据
        ServerSocket serverSocket = null;
        int port = 8080;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        }  catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        try {
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
        } catch (IOException e) {

        }
    }
}
