package com.rockeseat.planner.activities;

import java.time.LocalDateTime;
import java.util.UUID;

public record ActivityData(UUID id, String title, LocalDateTime occours_at) {
}
