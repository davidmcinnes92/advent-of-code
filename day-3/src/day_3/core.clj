(ns day-3.core
  (:gen-class))

(require '[clojure.string :as str])

(def directions { :north 0
                  :east 1
                  :south 2
                  :west 3 
                  :south-west { :cool "Super Cool!"
                                :lame "Super Lame!"
                  }})

(def input (slurp "resources/input.txt"))
;;(def input-test (slurp "resources/input_test.txt"))
(def numbers (str/split-lines input))
;;(def 2d-numbers (to-array-2d input))

;; (defn gamma-rate []
;;   (def indexer (atom 0))
;;   (def total-0 (atom 0))
;;   (def total-1 (atom 0))
;;   (def results-array (make-array Integer/TYPE 8))
;;   (aset-int results-array @indexer 0)
;;   (while (< @indexer 8)
;;     (do (doseq [x numbers]
;;       (def binary-element (get x @indexer))
;;       (if (= binary-element 0) (swap! total-0 inc) (swap! total-1 inc))))))
;;     (if (> @total-0 @total-1) (aset-int results-array @indexer 0) (aset-int results-array @indexer 1))))
;;     (swap! indexer inc))
;;   (println results-array))

(defn epsilon-rate []
  (def indexer (atom 0))
  (def total-0 (atom 0))
  (def total-1 (atom 0))
  (def results-array (make-array Integer/TYPE 12))
  (while (< @indexer 12)
    (do (doseq [x numbers]
      (def binary-element (Character/digit (get x @indexer) 12))
      (if (= binary-element 0) (swap! total-0 inc))
      (if (= binary-element 1) (swap! total-1 inc))
  (if (> @total-0 @total-1) (aset-int results-array @indexer 0) (aset-int results-array @indexer 1))))
  (println "total-0 is" @total-0)
  (println "total-1 is" @total-1)
  (swap! indexer inc))
  (println (java.util.Arrays/toString results-array)))

(defn if-test []
  (def binary-element 0)
  (if (= binary-element 0) (println "Binary Element is" binary-element)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;;(if-test)
  (println directions)
  (def sub-directions (:south-west directions))
  (map remove sub-directions)
  (println directions)
  (println (:cool sub-directions))
  (println (:north directions))
  (println (directions :south))
  (println "Hello, World!"))
