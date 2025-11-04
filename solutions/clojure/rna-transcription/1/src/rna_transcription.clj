(ns rna-transcription)

(def rnamap
  {\G \C, \C \G, \T \A, \A \U})

(defn to-rna [dna]
  (if
   (some #(not (contains? (set (keys rnamap)) %)) dna)
    (throw (AssertionError. "invalid character in dna string"))
    (apply str (map rnamap dna))))
