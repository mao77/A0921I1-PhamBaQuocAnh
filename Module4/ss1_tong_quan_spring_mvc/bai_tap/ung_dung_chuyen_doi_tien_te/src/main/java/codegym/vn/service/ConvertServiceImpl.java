package codegym.vn.service;

import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements ConvertService {
    @Override
    public double calculator(double usd) {
        double vnd = usd *21000;
        return vnd;
    }
}
