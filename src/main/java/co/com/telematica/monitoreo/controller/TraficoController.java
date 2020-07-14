package co.com.telematica.monitoreo.controller;

import co.com.telematica.monitoreo.database.model.Trafico;
import co.com.telematica.monitoreo.service.TraficoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/trafico/")
public class TraficoController {
    @Autowired
    TraficoService traficoService;

    @GetMapping("lista")
    public List<Trafico> getTrafico() throws InterruptedException, IOException, ClassNotFoundException {
        Trafico trafico = new Trafico();
        trafico.setTrafico(socket());
        traficoService.guardarRegistro(trafico);
        return this.traficoService.getTrafico();
    }

    private String socket() throws IOException, ClassNotFoundException, InterruptedException {
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        String message = "";
        for(int i=0; i<1;i++){
            socket = new Socket(host.getHostName(), 9876);
            oos = new ObjectOutputStream(socket.getOutputStream());
            if(i==1)oos.writeObject("salir");
            else oos.writeObject(""+i);
            ois = new ObjectInputStream(socket.getInputStream());
            message = (String) ois.readObject();
            ois.close();
            oos.close();
            Thread.sleep(100);
        }
        return message;
    }
}
