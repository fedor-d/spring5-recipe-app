package pw.springdev.services;

import java.util.Set;

import pw.springdev.commands.UnitOfMeasureCommand;

/**
 * Created by FedorD on 2020-04-16
 */
public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}
