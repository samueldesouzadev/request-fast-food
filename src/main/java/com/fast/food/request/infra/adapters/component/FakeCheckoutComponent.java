package com.fast.food.request.infra.adapters.component;

import com.fast.food.request.infra.adapters.constants.PaymentStatusEnum;
import com.fast.food.request.infra.adapters.entities.DemandEntity;
import com.fast.food.request.infra.adapters.repositories.jpa.DemandJPARepository;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableScheduling
public class FakeCheckoutComponent {

    private final DemandJPARepository demandJPARepository;

    public FakeCheckoutComponent(DemandJPARepository demandJPARepository) {
        this.demandJPARepository = demandJPARepository;
    }

    private static final String TIME_ZONE = "America/Sao_Paulo";

    @Scheduled(cron = "*/6 * * * * *", zone = TIME_ZONE)
    public void cron() {
        List<DemandEntity> demandEntityList = demandJPARepository.findDemandEntitiesByNotComplete();
        if (!demandEntityList.isEmpty()) {
            for (DemandEntity demandEntity : demandEntityList) {
                if (demandEntity.getPaymentStatus().equals(PaymentStatusEnum.NOT_PAY)) {
                    demandEntity.setPaymentStatus(PaymentStatusEnum.PAID);
                    demandJPARepository.save(demandEntity);
                    System.out.println("PEDIDO ATUALIZADO PARA - PEDIDO PADO");
                }
            }
        }
    }
}
