package a1.test.task.task3.dto;

import java.time.LocalDate;

public record PostingDto(
         Long id,
         String matDoc,
         String item,
         LocalDate docDate,
         LocalDate postDate,
         String materialDescription,
         Integer quantity,
         String bun,
         String amountLc,
         String crcy,
         String username,
         boolean authorizedDelivery
) {

}
