package com.learning.ai.dto;

import java.util.List;

public record MovieRecommendation(
        String title,
        int releaseYear,
        String genre,
        String summary,
        List<String> keyThemes,
        String whyYouWillLikeIt
) {}
