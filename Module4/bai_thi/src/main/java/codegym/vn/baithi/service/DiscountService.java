package codegym.vn.baithi.service;

import codegym.vn.baithi.entity.Discount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DiscountService {
    Page<Discount> listAll(Pageable pageable);
    void create(Discount discount);
    Discount findById(int id);
    void edit(Discount discount);
    void deleteById(int id);
    Page<Discount> searchDiscount(String discountPrice,String startDate, Pageable pageable);
}
