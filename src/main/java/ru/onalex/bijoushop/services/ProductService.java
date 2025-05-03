package ru.onalex.bijoushop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.onalex.bijoushop.entities.BjProduct;
import ru.onalex.bijoushop.entities.ProductGroup;
import ru.onalex.bijoushop.repositories.GroupProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class ProductService {

        private final GroupProductRepository groupProductRepository;

        public ProductService(GroupProductRepository groupProductRepository) {
            this.groupProductRepository = groupProductRepository;
        }

        // Получить товары по ID категории
        public List<BjProduct> getProductsByGroupId(Integer groupId) {
            return groupProductRepository.findByGroupId(groupId)
                    .stream()
                    .map(ProductGroup::getBjProduct)
                    .collect(Collectors.toList());
        }

}
