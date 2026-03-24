#include "lasagna_master.h"

namespace lasagna_master {

  int preparationTime (const std::vector<std::string>& layers, int time) {
    return layers.size() * time;
  }

  amount quantities (const std::vector<std::string>& layers) {
    amount quants{};
    for (std::string layer : layers) {
      if (layer == "noodles") {
        quants.noodles += 50;
      } else if (layer == "sauce") {
        quants.sauce += 0.2;
      }
    }
    return quants;
  }

  void addSecretIngredient (std::vector<std::string>& myRecipe, const std::vector<std::string>& friendRecipe) {
    myRecipe.back() = friendRecipe.back();
  }

  void addSecretIngredient (std::vector<std::string>& myRecipe, const std::string secret) {
    myRecipe.back() = secret;
  }

  std::vector<double> scaleRecipe (const std::vector<double>& quants, const double portions) {
    double modifier = portions / 2;
    std::vector<double> newQuants;
    for(double quant : quants) {
      newQuants.push_back(quant * modifier);
    }
    return newQuants;
  }
}  // namespace lasagna_master
