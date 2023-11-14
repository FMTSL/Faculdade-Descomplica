package service;

import entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PedidoRepository;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public List<Pedido> getAll(){
        return pedidoRepository.findAll();
    }

    public Pedido getById(Integer id){
        return pedidoRepository.findById(id).orElse(null);
    }

    public Pedido savePedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    public Pedido updatePedido(Integer id, Pedido pedido) {
        Pedido pedidoAtualizada = pedidoRepository.findById(id).orElse(null);
        if (pedidoAtualizada != null){
            pedidoAtualizada.setPedidoData(pedido.getPedidoData());
            return pedidoRepository.save(pedidoAtualizada);
        }

        else {
            return null;
        }
    }

    public Boolean deletePedido(Integer id) {
        Pedido pedido = pedidoRepository.findById(id).orElse(null);
        if (pedido != null){
            pedidoRepository.delete(pedido);
            return true;
        }
        else {
            return false;
        }
    }
}
