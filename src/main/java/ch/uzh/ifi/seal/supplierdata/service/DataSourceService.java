package ch.uzh.ifi.seal.supplierdata.service;

import ch.uzh.ifi.seal.currency.model.Currency;
import ch.uzh.ifi.seal.supplierdata.model.DataSource;
import ch.uzh.ifi.seal.supplierdata.model.Supplier;
import ch.uzh.ifi.seal.supplierdata.model.SupplierPurchaseData;
import java.util.List;
import java.util.stream.Collectors;

public class DataSourceService {
    public SupplierPurchaseData findSupplierPurchaseData(Supplier supplier, String productName, String manufacturerKey, String ean) {
        DataSource dataSource = new DataSource(supplier);
        dataSource.connect();
        List<SupplierPurchaseData> supplierPurchaseDatas = dataSource.download();

        List<SupplierPurchaseData> matched = supplierPurchaseDatas.stream()
                .filter(spd -> spd.ManufacturerKey.equals(manufacturerKey)
                    && spd.ProductName.equals(productName)
                    && spd.Ean.equals(ean))
                .collect(Collectors.toList());

        if (matched.size() > 0) {
            return matched.get(0);
        }

        return new SupplierPurchaseData(
                supplier,
                "9783598215179",
                "ZZZ-456",
                "Test product",
                "Test",
                11,
                45,
                Currency.CHF);
    }
}
