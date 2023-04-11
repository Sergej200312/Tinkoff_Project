package DTO;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.OffsetDateTime;


public record RepositoryInfoResponse (@NonNull String full_name, @NonNull OffsetDateTime updated_at, @NonNull OffsetDateTime pushed_at){

}
