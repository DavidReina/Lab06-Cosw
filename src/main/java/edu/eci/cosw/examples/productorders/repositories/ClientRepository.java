/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.examples.productorders.repositories;

import edu.eci.cosw.samples.model.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author David Reina
 */
public interface ClientRepository extends JpaRepository<Cliente, Integer>{
    
    @Query("select distinct cliente from Pedido as ped inner join ped.cliente as cliente inner join ped.detallesPedidos as detalle inner join detalle.producto as producto where producto.precio > ?1")
    List<Cliente> findCLientesByPrecioProducto(long precio);
    
}
