package ch.uzh.ifi.seal.supplierdata.controller;

import ch.uzh.ifi.seal.currency.model.Currency;
import ch.uzh.ifi.seal.supplierdata.model.Supplier;
import ch.uzh.ifi.seal.supplierdata.model.SupplierPurchaseData;
import ch.uzh.ifi.seal.supplierdata.service.DataSourceService;
import ch.uzh.ifi.seal.supplierdata.service.SupplierService;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SupplierDataController {
    private final DataSourceService dataSourceService;
    private final SupplierService supplierService;

    public SupplierDataController() {
        dataSourceService = new DataSourceService();
        supplierService = new SupplierService();
    }

    public List<SupplierPurchaseData> findSupplierData(String productName, String manufacturerKey, String ean) {
        //Try to find matching products in the datasources of our swiss suppliers
        Set<Supplier> suppliers = supplierService.getSwissSuppliers();
        List<SupplierPurchaseData> supplierPurchaseDataList = suppliers.stream()
                .map(s -> dataSourceService.findSupplierPurchaseData(s, productName, manufacturerKey, ean))
                .collect(Collectors.toList());

        //We also know that some suppliers without a datasource offer this product so we create the data manually
        supplierPurchaseDataList.add(new SupplierPurchaseData(
                new Supplier("TT Trading"),
                ean, manufacturerKey, productName, "", 1, 25.55, Currency.CHF));

        supplierPurchaseDataList.add(new SupplierPurchaseData(
                new Supplier("HighLow Investments"),
                ean, manufacturerKey, productName, "", 1, 20.156, Currency.CHF));

        return supplierPurchaseDataList;
    }
}
