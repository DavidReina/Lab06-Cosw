/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.examples.productorders.repositories;

import edu.eci.cosw.samples.model.Despacho;
import edu.eci.cosw.samples.model.Vehiculo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author David Reina
 */
public interface VehicleRepository extends JpaRepository<Vehiculo, String>{
    
    @Query("select distinct vehiculo from Despacho as des inner join des.pedidos as pedido inner join pedido.cliente as cliente inner join pedido.detallesPedidos as det inner join det.producto as producto inner join des.vehiculo as vehiculo where producto.idproducto=?1")
    List<Vehiculo> findVehiculosByIdProducto(int idProducto);
    
}
