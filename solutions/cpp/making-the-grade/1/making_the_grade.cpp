#include <array>
#include <string>
#include <vector>

// Round down all provided student scores.
std::vector<int> round_down_scores(std::vector<double> student_scores) {
  std::vector<int> rounded_scores {};
  for (double score : student_scores) {
    rounded_scores.emplace_back(score);
  }
    return rounded_scores;
}

// Count the number of failing students out of the group provided.
int count_failed_students(std::vector<int> student_scores) {
  int fails{0};
  for (int score : student_scores) {
    if (score <= 40) {
      fails += 1;
    }
  }
    return fails;
}

// Create a list of grade thresholds based on the provided highest grade.
std::array<int, 4> letter_grades(int highest_score) {
  int interval{(highest_score-40)/4};
  std::array<int, 4> grades{41};
  for (int i = 1; i < 4; i++) {
    grades[i] = 41 + (i * interval);
  }
    return grades;
}

// Organize the student's rank, name, and grade information in ascending order.
std::vector<std::string> student_ranking(
    std::vector<int> student_scores, std::vector<std::string> student_names) {
  std::vector<std::string> rankings {};
  for (int i = 0; i < student_scores.size() ; ++i) {
    rankings.emplace_back(std::to_string(i + 1) + ". " + student_names[i] + ": " + std::to_string(student_scores[i]));
  }
    return rankings;
}

// Create a string that contains the name of the first student to make a perfect
// score on the exam.
std::string perfect_score(std::vector<int> student_scores,
                          std::vector<std::string> student_names) {
  for (int i = 0; i < student_scores.size(); i++) {
    if (student_scores[i] == 100) {
      return student_names[i];
    }
  }
    return "";
}
