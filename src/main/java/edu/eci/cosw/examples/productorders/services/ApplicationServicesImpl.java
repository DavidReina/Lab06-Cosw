/*
 * Copyright (C) 2016 Pivotal Software, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.cosw.examples.productorders.services;

import edu.eci.cosw.examples.productorders.repositories.ClientRepository;
import edu.eci.cosw.examples.productorders.repositories.DispatchRepository;
import edu.eci.cosw.examples.productorders.repositories.OrdersRepository;
import edu.eci.cosw.examples.productorders.repositories.ProductsRepository;
import edu.eci.cosw.examples.productorders.repositories.VehicleRepository;
import edu.eci.cosw.samples.model.Cliente;
import edu.eci.cosw.samples.model.Despacho;
import edu.eci.cosw.samples.model.Pedido;
import edu.eci.cosw.samples.model.Producto;
import edu.eci.cosw.samples.model.Vehiculo;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hcadavid
 */
@Service
public class ApplicationServicesImpl implements ApplicationServices{
   
    @Autowired
    private OrdersRepository ordrepo;

    @Autowired
    private ProductsRepository prorepo;
    
    @Autowired
    private DispatchRepository disprepo;
    
    @Autowired
    private ClientRepository clienterepo;
    
    @Autowired
    private VehicleRepository vehiclerepo;
    
    
    @Override
    public List<Pedido> getAllOrders() throws ServicesException{
        List<Pedido> p=ordrepo.findAll();
        return p;
    }

    @Override
    public List<Producto> getAllProducts() throws ServicesException{
        return  prorepo.findAll();
    }

    @Override
    public Pedido orderById(Integer id) throws ServicesException{
        return ordrepo.findOne(id);
    }
    
    
    @Override
    public Despacho dispatchByID(Integer id) throws ServicesException{
        return disprepo.findOne(id);
    }

    @Override
    public List<Vehiculo> getAllVehiclesByIdProduct(int idProducto) throws ServicesException {
        return vehiclerepo.findVehiculosByIdProducto(idProducto); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> getAllCLientsByPriceProduct(long precio) throws ServicesException {
    return  clienterepo.findCLientesByPrecioProducto(precio);//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registerDistpatch(Despacho desp) throws ServicesException {
        
       disprepo.saveAndFlush(desp);
    //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vehiculo vehicleById(String placa) throws ServicesException {
     return vehiclerepo.findOne(placa);
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
