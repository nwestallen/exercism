#include "leap.h"

namespace leap {

  bool is_leap_year(int year) {
    if (year % 400 == 0) {
      return true;
    } else if (year % 100 == 0) {
      return false;
    } else {
      return year % 4 == 0;
    }
  }

}  // namespace leap
