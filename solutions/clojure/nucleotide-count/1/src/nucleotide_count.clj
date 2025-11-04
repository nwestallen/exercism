(ns nucleotide-count)

(defn count-of-nucleotide-in-strand [nucleotide strand]
  (if (not (contains? #{\A \T \C \G} nucleotide))
      (throw (IllegalArgumentException. "invalid nucleotide"))
      (count (filter #(= nucleotide %) strand))))

(defn nucleotide-counts [strand]
  (apply merge (map #(hash-map % (count-of-nucleotide-in-strand % strand)) '(\A \T \C \G))))
