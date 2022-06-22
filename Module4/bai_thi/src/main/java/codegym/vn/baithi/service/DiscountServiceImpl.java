package codegym.vn.baithi.service;

import codegym.vn.baithi.entity.Discount;
import codegym.vn.baithi.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DiscountServiceImpl implements DiscountService{
    @Autowired
    private DiscountRepository discountRepository;
    @Override
    public Page<Discount> listAll(Pageable pageable) {
        return discountRepository.findAll(pageable);
    }

    @Override
    public void create(Discount discount) {
        discountRepository.save(discount);
    }

    @Override
    public Discount findById(int id) {
        return null;
    }

    @Override
    public void edit(Discount discount) {

    }

    @Override
    public void deleteById(int id) {
        discountRepository.deleteById(id);
    }

    @Override
    public Page<Discount> searchDiscount(String discountPrice, String startDate, Pageable pageable) {
        return discountRepository.searchDiscount(discountPrice,startDate,pageable);
    }
}
