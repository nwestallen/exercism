(ns acronym)

(defn acronym
  "Converts phrase to its acronym."
  [phrase]
  (clojure.string/upper-case
   (apply str (map first (clojure.string/split phrase #"\s|-|(?=\p{Upper})(?<!\p{Upper})")))
   )
  )
