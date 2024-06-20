package io.mymanager.desktop.data.dao;

import io.mymanager.desktop.data.models.Currency;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface CurrencyDao {

  List<Currency> findAllCurrencies() throws Exception;

  List<Currency> findCurrencies(String currencyName) throws Exception;

  int updateCurrency(Currency oldCurrency, Currency newCurrency) throws Exception;

  int saveCurrency(Currency currency) throws Exception;

  int deleteCurrency(Currency currency) throws Exception;

}
