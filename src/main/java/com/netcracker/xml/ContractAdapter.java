package com.netcracker.xml;

import com.netcracker.contract.Contract;
import com.netcracker.contract.Internet;
import com.netcracker.contract.Mobile;
import com.netcracker.contract.Television;

import javax.xml.bind.annotation.adapters.XmlAdapter;


/**
 * Класс-адаптер для преобразования контрактов в xml
 */
public class ContractAdapter extends XmlAdapter<XmlContract, Contract> {
    /**
     *
     * @param xmlContract Контракт, полученный из xml документа
     * @return Результирующий контракт
     */
    @Override
    public Contract unmarshal(XmlContract xmlContract) throws Exception {
        if (xmlContract == null) {
            return null;
        }

        if (xmlContract.channelPackage != null) {
            return new Television(
                    xmlContract.id,
                    xmlContract.beginDate,
                    xmlContract.endDate,
                    xmlContract.person,
                    xmlContract.channelPackage
            );

        } else if (xmlContract.mb != 0
                && xmlContract.min != 0
                && xmlContract.sms != 0) {
            return new Mobile(
                    xmlContract.id,
                    xmlContract.beginDate,
                    xmlContract.endDate,
                    xmlContract.person,
                    xmlContract.mb,
                    xmlContract.min,
                    xmlContract.sms
            );
        } else {
            return new Internet(
                    xmlContract.id,
                    xmlContract.beginDate,
                    xmlContract.endDate,
                    xmlContract.person,
                    xmlContract.maxSpeed
            );
        }
    }

    /**
     *
     * @param contract контракт
     * @return Контракт для преобразования в xml
     */
    @Override
    public XmlContract marshal(Contract contract) throws Exception {
        if (contract == null) {
            return null;
        }
        XmlContract xmlContract = new XmlContract();
        xmlContract.id = contract.getID();
        xmlContract.beginDate = contract.getBeginDate();
        xmlContract.endDate = contract.getEndDate();
        xmlContract.person = contract.getClient();
        if (contract instanceof Mobile) {
            Mobile mobile = (Mobile) contract;
            xmlContract.sms = mobile.getSms();
            xmlContract.mb = mobile.getMb();
            xmlContract.min = mobile.getMin();
        } else if (contract instanceof Television) {
            Television television = (Television) contract;
            xmlContract.channelPackage = television.getChannelPackage();
        } else {
           Internet internet = (Internet) contract;
            xmlContract.maxSpeed = internet.getMaxSpeed();
        }
        return xmlContract;
    }
}