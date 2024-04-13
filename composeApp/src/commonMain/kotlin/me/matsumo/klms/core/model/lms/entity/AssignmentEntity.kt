package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Represents the due dates, requirements, and other details of an assignment
@Serializable
data class AssignmentEntity(
    // the ID of the assignment
    @SerialName("id") val id: Int,
    // the name of the assignment
    @SerialName("name") val name: String,
    // the assignment description, in an HTML fragment
    @SerialName("description") val description: String,
    // The time at which this assignment was originally created
    @SerialName("created_at") val createdAt: String,
    // The time at which this assignment was last modified in any way
    @SerialName("updated_at") val updatedAt: String,
    // the due date for the assignment
    @SerialName("due_at") val dueAt: String?,
    // the lock date (assignment is locked after this date)
    @SerialName("lock_at") val lockAt: String?,
    // the unlock date (assignment is unlocked after this date)
    @SerialName("unlock_at") val unlockAt: String?,
    // whether this assignment has overrides
    @SerialName("has_overrides") val hasOverrides: Boolean,
    // the ID of the course the assignment belongs to
    @SerialName("course_id") val courseId: Int,
    // the URL to the assignment's web page
    @SerialName("html_url") val htmlUrl: String,
    // the URL to download all submissions as a zip
    @SerialName("submissions_download_url") val submissionsDownloadUrl: String,
    // the ID of the assignment's group
    @SerialName("assignment_group_id") val assignmentGroupId: Int,
    // Boolean flag indicating whether the assignment requires a due date based on the account level setting
    @SerialName("due_date_required") val dueDateRequired: Boolean,
    // Allowed file extensions
    @SerialName("allowed_extensions") val allowedExtensions: List<String>?,
    // An integer indicating the maximum length an assignment's name may be
    @SerialName("max_name_length") val maxNameLength: Int,
    // Boolean flag indicating whether or not Turnitin has been enabled for the assignment
    @SerialName("turnitin_enabled") val turnitinEnabled: Boolean,
    // Boolean flag indicating whether or not VeriCite has been enabled for the assignment
    @SerialName("vericite_enabled") val vericiteEnabled: Boolean,
    // If this is a group assignment, boolean flag indicating whether or not students will be graded individually
    @SerialName("grade_group_students_individually") val gradeGroupStudentsIndividually: Boolean,
    // Boolean indicating if peer reviews are required for this assignment
    @SerialName("peer_reviews") val peerReviews: Boolean,
    // Boolean indicating peer reviews are assigned automatically
    @SerialName("automatic_peer_reviews") val automaticPeerReviews: Boolean,
    // Integer representing the amount of reviews each user is assigned
    @SerialName("peer_review_count") val peerReviewCount: Int?,
    // String representing a date the reviews are due by
    @SerialName("peer_reviews_assign_at") val peerReviewsAssignAt: String?,
    // Boolean representing whether or not members from within the same group on a group assignment can be assigned to peer review their own group's work
    @SerialName("intra_group_peer_reviews") val intraGroupPeerReviews: Boolean,
    // The ID of the assignment’s group set, if this is a group assignment
    @SerialName("group_category_id") val groupCategoryId: Int?,
    // if the requesting user has grading rights, the number of submissions that need grading
    @SerialName("needs_grading_count") val needsGradingCount: Int,
    // the sorting order of the assignment in the group
    @SerialName("position") val position: Int,
    // the maximum points possible for the assignment
    @SerialName("points_possible") val pointsPossible: Double,
    // the types of submissions allowed for this assignment
    @SerialName("submission_types") val submissionTypes: List<String>,
    // Whether the assignment is published
    @SerialName("published") val published: Boolean,
    // Whether the assignment's 'published' state can be changed to false
    @SerialName("unpublishable") val unpublishable: Boolean,
    // Whether the assignment is only visible to overrides
    @SerialName("only_visible_to_overrides") val onlyVisibleToOverrides: Boolean,
    // Whether or not this is locked for the user
    @SerialName("locked_for_user") val lockedForUser: Boolean,
    // An explanation of why this is locked for the user
    @SerialName("lock_explanation") val lockExplanation: String?,
    // If true, the rubric is directly tied to grading the assignment
    @SerialName("use_rubric_for_grading") val useRubricForGrading: Boolean?,
    // Whether the assignment is moderated
    @SerialName("moderated_grading") val moderatedGrading: Boolean,
    // The maximum number of provisional graders who may issue grades for this assignment
    @SerialName("grader_count") val graderCount: Int,
    // The user ID of the grader responsible for choosing final grades for this assignment
    @SerialName("final_grader_id") val finalGraderId: Int?,
    // Boolean indicating if provisional graders' comments are visible to other provisional graders
    @SerialName("grader_comments_visible_to_graders") val graderCommentsVisibleToGraders: Boolean,
    // Boolean indicating if the assignment is graded anonymously
    @SerialName("anonymous_grading") val anonymousGrading: Boolean,
    // The number of submission attempts a student can make for this assignment
    @SerialName("allowed_attempts") val allowedAttempts: Int,
    // Whether the assignment has manual posting enabled
    @SerialName("post_manually") val postManually: Boolean,
    // If true, the assignment will be omitted from the student's final grade
    @SerialName("omit_from_final_grade") val omitFromFinalGrade: Boolean?,
    // Boolean indicating whether peer reviews are anonymous
    @SerialName("anonymous_peer_reviews") val anonymousPeerReviews: Boolean,
    // Boolean indicating whether instructor annotations are anonymous
    @SerialName("anonymous_instructor_annotations") val anonymousInstructorAnnotations: Boolean,
    // Boolean indicating whether this assignment has graded submissions
    @SerialName("graded_submissions_exist") val gradedSubmissionsExist: Boolean,
    // String indicating what state this assignment is in
    @SerialName("workflow_state") val workflowState: String,
    // all dates associated with the assignment, if applicable
    @SerialName("all_dates") val allDates: List<AssignmentDateEntity>?,
    // assignment's settings for external tools if submission_types include 'external_tool'
    @SerialName("external_tool_tag_attributes") val externalToolTagAttributes:
    me.matsumo.klms.core.model.lms.entity.ExternalToolTagAttributesEntity?,
    // If retrieving a single assignment and 'can_submit' is included in the 'include' parameter, flags whether user has the right to submit the assignment
    @SerialName("can_submit") val canSubmit: Boolean?,
    // Settings to control what kinds of matches should be considered by Turnitin
    @SerialName("turnitin_settings") val turnitinSettings:
    me.matsumo.klms.core.model.lms.entity.TurnitinSettingsEntity?,
    // the number of submissions that need grading split out by section
    @SerialName("needs_grading_count_by_section") val needsGradingCountBySection:
    List<me.matsumo.klms.core.model.lms.entity.NeedsGradingCountEntity>?,
    // Optional settings for rubric evaluation
    // @SerialName("rubric_settings") val rubricSettings: RubricSettingsEntity?,
    // A list of scoring criteria and ratings for each rubric criterion
    @SerialName("rubric") val rubric: List<me.matsumo.klms.core.model.lms.entity.RubricCriteriaEntity>?,
    // an array of student IDs who can see this assignment
    @SerialName("assignment_visibility") val assignmentVisibility: List<Int>?,
    // an array of assignment override objects
    @SerialName("overrides") val overrides: List<me.matsumo.klms.core.model.lms.entity.AssignmentOverrideEntity>?,
    // Information for the user about the lock
    @SerialName("lock_info") val lockInfo: me.matsumo.klms.core.model.lms.entity.LockInfoEntity?,
    // (Optional) the DiscussionTopic associated with the assignment, if applicable
    @SerialName("discussion_topic") val discussionTopic: me.matsumo.klms.core.model.lms.entity.DiscussionTopicEntity?,
    // (Optional) Array of frozen attributes for the assignment
    @SerialName("frozen_attributes") val frozenAttributes: List<String>?,
    // (Optional) If 'score_statistics' and 'submission' are included in the 'include' parameter and statistics are available, includes the min, max, and mode for this assignment
    @SerialName("score_statistics") val scoreStatistics: me.matsumo.klms.core.model.lms.entity.ScoreStatisticEntity?,
    // (Optional) The academic benchmark(s) associated with the assignment or the assignment's rubric
    @SerialName("ab_guid") val abGuid: List<String>?,
    // The id of the attachment to be annotated by students
    @SerialName("annotatable_attachment_id") val annotatableAttachmentId: Int?,
    // Boolean indicating whether student names are anonymized
    @SerialName("anonymize_students") val anonymizeStudents: Boolean?,
    // Boolean indicating whether the Respondus LockDown Browser® is required for this assignment
    @SerialName("require_lockdown_browser") val requireLockdownBrowser: Boolean?,
    // Boolean indicating whether this assignment has important dates
    @SerialName("important_dates") val importantDates: Boolean?,
    // Boolean indicating whether notifications are muted for this assignment
    @SerialName("muted") val muted: Boolean?,
    // Boolean indicating whether this is a quiz lti assignment
    @SerialName("is_quiz_assignment") val isQuizAssignment: Boolean?,
    // Boolean indicating whether this assignment is in a closed grading period
    @SerialName("in_closed_grading_period") val inClosedGradingPeriod: Boolean?,
    // Boolean indicating whether this assignment can be duplicated
    @SerialName("can_duplicate") val canDuplicate: Boolean?,
    // If this assignment is a duplicate, it is the original assignment's course_id
    @SerialName("original_course_id") val originalCourseId: Int?,
    // If this assignment is a duplicate, it is the original assignment's id
    @SerialName("original_assignment_id") val originalAssignmentId: Int?,
    // If this assignment is a duplicate, it is the original assignment's lti_resource_link_id
    @SerialName("original_lti_resource_link_id") val originalLtiResourceLinkId: Int?,
    // If this assignment is a duplicate, it is the original assignment's name
    @SerialName("original_assignment_name") val originalAssignmentName: String?,
    // If this assignment is a duplicate, it is the original assignment's quiz_id
    @SerialName("original_quiz_id") val originalQuizId: Int?,
    // (optional, Third Party unique identifier for Assignment)
    @SerialName("integration_id") val integrationId: String?,
    // (optional, Third Party integration data for assignment)
    @SerialName("integration_data") val integrationData: Map<String, String>?,
)
