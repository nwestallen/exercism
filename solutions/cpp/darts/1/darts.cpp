#include "darts.h"

namespace darts {

  int score(double x, double y) {
    double radsquared = (x * x) + (y * y);
    if (radsquared > 100) {
      return 0;
    } else if (radsquared > 25) {
      return 1;
    } else if (radsquared > 1) {
      return 5;
    } else {
      return 10;
    }
  }

}  // namespace darts
