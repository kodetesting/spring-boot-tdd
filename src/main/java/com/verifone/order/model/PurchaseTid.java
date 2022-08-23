package com.verifone.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseTid {
    @Id
    private String tid;
    private PurchaseTidStatusEnum status;

    private String reference;

    private UUID createdUserUid;
    private UUID modifiedUserUid;

    private String createdBy;
    private String modifiedBy;

    private OffsetDateTime createdDate;
    private OffsetDateTime modifiedDate;
}


