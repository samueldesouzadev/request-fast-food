package com.fast.food.request.infra.adapters.component;

import com.fast.food.request.infra.adapters.constants.DemandStatusEnum;
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
        System.out.println("ATUALIZANDO STATUS DO PEDIDOS");
        List<DemandEntity> demandEntityList = demandJPARepository.findDemandEntitiesByNotDemandStatus();
        if (!demandEntityList.isEmpty()) {
            for (DemandEntity demandEntity : demandEntityList) {
                if (demandEntity.getDemandStatus().equals(DemandStatusEnum.RECEIVED)) {
                    demandEntity.setDemandStatus(DemandStatusEnum.IN_PREPARATION);
                    demandJPARepository.save(demandEntity);
                    System.out.println("PEDIDO ATUALIZADO PARA - IN_PREPARATION");
                } else if (demandEntity.getDemandStatus().equals(DemandStatusEnum.IN_PREPARATION)) {
                    demandEntity.setDemandStatus(DemandStatusEnum.READY);
                    demandJPARepository.save(demandEntity);
                    System.out.println("PEDIDO ATUALIZADO PARA - READY");
                } else if (demandEntity.getDemandStatus().equals(DemandStatusEnum.READY)) {
                    demandEntity.setDemandStatus(DemandStatusEnum.COMPLETED);
                    demandJPARepository.save(demandEntity);
                    System.out.println("PEDIDO ATUALIZADO PARA - COMPLETED");
                }
            }
        } else {
            System.out.println("NENHUM PEDIDO PARA ATUALIZAR");
        }
    }
}
