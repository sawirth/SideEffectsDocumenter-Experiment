package ch.uzh.ifi.seal.supplierdata.controller;

import ch.uzh.ifi.seal.currency.model.Currency;
import ch.uzh.ifi.seal.supplierdata.model.Supplier;
import ch.uzh.ifi.seal.supplierdata.model.SupplierPurchaseData;
import ch.uzh.ifi.seal.supplierdata.service.DataSourceService;
import ch.uzh.ifi.seal.supplierdata.service.SupplierService;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        List<SupplierPurchaseData> supplierPurchaseDataList = createSupplierPurchaseData(suppliers, productName, manufacturerKey, ean);
        //We also know that some suppliers without a datasource offer this product so we create the data manually
        supplierPurchaseDataList.add(new SupplierPurchaseData(new Supplier("TT Trading"), ean, manufacturerKey, productName, "", 1, 25.55, Currency.CHF));
        supplierPurchaseDataList.add(new SupplierPurchaseData(new Supplier("HighLow Investments"), ean, manufacturerKey, productName, "", 1, 20.156, Currency.CHF));
        return supplierPurchaseDataList;
    }

    private List<SupplierPurchaseData> createSupplierPurchaseData(Set<Supplier> suppliers, String productName, String manufacturerKey, String ean) {
        List<SupplierPurchaseData> supplierPurchaseData = new ArrayList<>();
        for (Supplier supplier : suppliers) {
            supplierPurchaseData.add(dataSourceService.findSupplierPurchaseData(supplier, productName, manufacturerKey, ean));
        }
        return supplierPurchaseData;
    }
}
