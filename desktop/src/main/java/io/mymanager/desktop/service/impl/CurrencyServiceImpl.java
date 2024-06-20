package io.mymanager.desktop.service.impl;

import io.mymanager.desktop.data.dao.CurrencyDao;
import io.mymanager.desktop.data.dao.impl.CurrencyDaoImpl;
import io.mymanager.desktop.data.models.Currency;
import io.mymanager.desktop.service.CurrencyService;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public class CurrencyServiceImpl implements CurrencyService {

  private final CurrencyDao currencyDao;

  public CurrencyServiceImpl() {
    super();
    this.currencyDao = new CurrencyDaoImpl();
  }

  @Override
  public List<Currency> getAllCurrencies() throws Exception {
    return currencyDao.findAllCurrencies();
  }

  @Override
  public List<Currency> getCurrencies(String currencyName) throws Exception {
    return currencyDao.findCurrencies(currencyName);
  }

  @Override
  public int updateCurrency(Currency oldCurrency, Currency newCurrency) throws Exception {
    return currencyDao.updateCurrency(oldCurrency, newCurrency);
  }

  @Override
  public int saveCurrency(Currency currency) throws Exception {
    return currencyDao.saveCurrency(currency);
  }

  @Override
  public int deleteCurrency(Currency currency) throws Exception {
    return currencyDao.deleteCurrency(currency);
  }

}
