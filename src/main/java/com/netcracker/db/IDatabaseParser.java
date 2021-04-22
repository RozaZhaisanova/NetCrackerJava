package com.netcracker.db;
import com.netcracker.contract.Contract;
import com.netcracker.person.Person;

import java.sql.SQLException;
/**
 * Интерфейс для созранения и восстановления контрактов
 */
public interface IDatabaseParser {
    void savePerson(Person person) throws SQLException;
    void saveContract(Contract contract) throws SQLException;
    void getAllContracts() throws SQLException;
    void getAllClients() throws SQLException;
}