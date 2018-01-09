package ch.uzh.ifi.seal.supplierdata.service;

import ch.uzh.ifi.seal.currency.model.Currency;
import ch.uzh.ifi.seal.supplierdata.model.DataSource;
import ch.uzh.ifi.seal.supplierdata.model.Supplier;
import ch.uzh.ifi.seal.supplierdata.model.SupplierPurchaseData;
import java.util.ArrayList;
import java.util.List;

public class DataSourceService {

    /**
     * Purity: Native   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: productName (String)      </li>
     * <li>      Argument: manufacturerKey (String)      </li>
     * <li>      Argument: ean (String)      </li>
     * <li>      Field of subclass: SupplierPurchaseData.ProductName (java.lang.String;)      </li>
     * <li>      Field of subclass: SupplierPurchaseData.Ean (java.lang.String;)      </li>
     * <li>      Field of subclass: SupplierPurchaseData.ManufacturerKey (java.lang.String;)      </li>
     * </ul>
     * 
     * The method calls native code:
     * <ul>
     * <li>      {@link DataSource#download} (origin: {@link java.util.Collection#toArray})      </li>
     * </ul>
     */
    public SupplierPurchaseData findSupplierPurchaseData(Supplier supplier, String productName, String manufacturerKey, String ean) {
        DataSource dataSource = new DataSource(supplier);
        dataSource.connect();
        List<SupplierPurchaseData> supplierPurchaseDatas = dataSource.download();
        List<SupplierPurchaseData> matched = findMatchingData(supplierPurchaseDatas, productName, manufacturerKey, ean);
        if (matched.size() > 0) {
            return matched.get(0);
        }
        return new SupplierPurchaseData(supplier, "9783598215179", "ZZZ-456", "Test product", "Test", 11, 45, Currency.CHF);
    }

    /**
     * Purity: Stateful   <br>
     * 
     * Return value depends on the following:
     * <ul>
     * <li>      Argument: supplierPurchaseDatas (List<SupplierPurchaseData>)      </li>
     * <li>      Argument: productName (String)      </li>
     * <li>      Argument: manufacturerKey (String)      </li>
     * <li>      Argument: ean (String)      </li>
     * <li>      Field of subclass: SupplierPurchaseData.ProductName (java.lang.String;)      </li>
     * <li>      Field of subclass: SupplierPurchaseData.ManufacturerKey (java.lang.String;)      </li>
     * <li>      Field of subclass: SupplierPurchaseData.Ean (java.lang.String;)      </li>
     * </ul>
     */
    private List<SupplierPurchaseData> findMatchingData(List<SupplierPurchaseData> supplierPurchaseDatas, String productName, String manufacturerKey, String ean) {
        List<SupplierPurchaseData> matchedData = new ArrayList<>();
        for (SupplierPurchaseData supplierPurchaseData : supplierPurchaseDatas) {
            if (supplierPurchaseData.ProductName.equals(productName) && supplierPurchaseData.ManufacturerKey.equals(manufacturerKey) && supplierPurchaseData.Ean.equals(ean)) {
                matchedData.add(supplierPurchaseData);
            }
        }
        return matchedData;
    }
}
