package com.learning.ai.dto;

import java.util.List;

public record CodeReviewResult(
        String overallRating, // EXCELLENT, GOOD, NEEDS_IMPROVEMENT, CRITICAL_ISSUES
        int score, // 1 - 100
        List<String> strengths,
        List<CodeIssue> issues,
        String refactoredCodeSummary
) {
    public record CodeIssue(
            String severity, // HIGH, MEDIUM, LOW
            String component,
            String problem,
            String suggestedFix
    ) {}
}
