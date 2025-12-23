(ns allergies)

(def known-allergies [:cats :pollen :chocolate :tomatoes :strawberries :shellfish :peanuts :eggs])

(defn allergies
  "Returns all allergens associated with the score."
  [score]
  (let [mask (mapv (partial = \1) (take-last 8 (Integer/toBinaryString score)))]
    (reverse (keep-indexed (fn [idx item] (when (mask idx) item)) (take-last (count mask) known-allergies)))
    )
  )

(defn allergic-to?
  "Returns true if the score indicates an allergy to the allergen;
  otherwise, it returns false."
  [score allergen]
  (contains? (set (allergies score)) allergen)
  )

