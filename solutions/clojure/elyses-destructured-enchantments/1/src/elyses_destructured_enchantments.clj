(ns elyses-destructured-enchantments)

(defn first-card
  "Returns the first card from deck."
  [[first-card]]
  first-card
)

(defn second-card
  "Returns the second card from deck."
  [[first-card second-card]]
  second-card
)

(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [[first-card second-card & others]]
  (conj others first-card second-card)
)

(defn discard-top-card
  "Returns a sequence containing the first card and
   a sequence of the remaining cards in the deck."
  [[first-card  & others]]
  [first-card others]
)

(def face-cards
  ["jack" "queen" "king"])

(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [deck]
  (remove nil? (flatten [(first deck) face-cards (rest deck)]))
)
