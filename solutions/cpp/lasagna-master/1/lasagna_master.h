#pragma once
#include <string>
#include<vector>

namespace lasagna_master {

struct amount {
  int noodles{0};
  double sauce{0};
};

  int preparationTime (const std::vector<std::string>& layers, int time=2);

  amount quantities (const std::vector<std::string>& layers);

  void addSecretIngredient (std::vector<std::string>& myRecipe, const std::vector<std::string>& friendRecipe);

  void addSecretIngredient (std::vector<std::string>& myRecipe, const std::string secret);

  std::vector<double> scaleRecipe (const std::vector<double>& quants, double portions);

}
// namespace lasagna_master
