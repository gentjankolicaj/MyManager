package io.mymanager.desktop.service;

import io.mymanager.desktop.data.models.Currency;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface CurrencyService {

  List<Currency> getAllCurrencies() throws Exception;

  List<Currency> getCurrencies(String currencyName) throws Exception;

  int updateCurrency(Currency oldCurrency, Currency newCurrency) throws Exception;

  int saveCurrency(Currency currency) throws Exception;

  int deleteCurrency(Currency currency) throws Exception;
}
