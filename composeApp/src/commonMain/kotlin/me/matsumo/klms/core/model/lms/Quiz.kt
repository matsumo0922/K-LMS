package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Quiz(
        val id: Int,

        val title: String,

        val htmlUrl: String,

        val mobileUrl: String,

        val previewUrl: String?,

        val description: String?,

        val quizType: String,

        val assignmentGroupId: Int,

        val timeLimit: Int?, 
        val shuffleAnswers: Boolean,

        val hideResults: String?,

        val showCorrectAnswers: Boolean,

        val showCorrectAnswersLastAttempt: Boolean,

        val showCorrectAnswersAt: String?,

        val hideCorrectAnswersAt: String?,

        val oneTimeResults: Boolean,

        val scoringPolicy: String,

        val allowedAttempts: Int,

        val oneQuestionAtATime: Boolean,

        val questionCount: Int,

        val pointsPossible: Int,

        val cantGoBack: Boolean,

        val accessCode: String?,

        val ipFilter: String?,

        val dueAt: String?,

        val lockAt: String?,

        val unlockAt: String?,

        val published: Boolean,

        val unpublishable: Boolean,

        val lockedForUser: Boolean,

        val lockInfo: LockInfoEntity?,

        val lockExplanation: String?,

        val speedgraderUrl: String?,

        val quizExtensionsUrl: String,

        val permissions: QuizPermissionsEntity?,

        val allDates: List<String>?, 
        val versionNumber: Int,

        val questionTypes: List<String>,

        val anonymousSubmissions: Boolean
)

fun QuizEntity.translate(): Quiz {
    return Quiz(
        id = id,
        title = title,
        htmlUrl = htmlUrl,
        mobileUrl = mobileUrl,
        previewUrl = previewUrl,
        description = description,
        quizType = quizType,
        assignmentGroupId = assignmentGroupId,
        timeLimit = timeLimit,
        shuffleAnswers = shuffleAnswers,
        hideResults = hideResults,
        showCorrectAnswers = showCorrectAnswers,
        showCorrectAnswersLastAttempt = showCorrectAnswersLastAttempt,
        showCorrectAnswersAt = showCorrectAnswersAt,
        hideCorrectAnswersAt = hideCorrectAnswersAt,
        oneTimeResults = oneTimeResults,
        scoringPolicy = scoringPolicy,
        allowedAttempts = allowedAttempts,
        oneQuestionAtATime = oneQuestionAtATime,
        questionCount = questionCount,
        pointsPossible = pointsPossible,
        cantGoBack = cantGoBack,
        accessCode = accessCode,
        ipFilter = ipFilter,
        dueAt = dueAt,
        lockAt = lockAt,
        unlockAt = unlockAt,
        published = published,
        unpublishable = unpublishable,
        lockedForUser = lockedForUser,
        lockInfo = lockInfo,
        lockExplanation = lockExplanation,
        speedgraderUrl = speedgraderUrl,
        quizExtensionsUrl = quizExtensionsUrl,
        permissions = permissions,
        allDates = allDates,
        versionNumber = versionNumber,
        questionTypes = questionTypes
    )
}
