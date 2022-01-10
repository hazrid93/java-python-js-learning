- Flattening: The process of converting a 2d image into 1d vector
- ReLU: An activation function that allows a model to solve nonlinear problems
- Softmax: A function that provides probabilities for each possible output class
- Classification: A machine learning model used for distinguishing among two or more output categories


- Jupyter notebook are the IDE use for data science, vscode support creating and running jupyter notebook (CTRL+SHIFT+P and select create new jupyter notebook)
[more_jupyter](https://code.visualstudio.com/docs/datascience/jupyter-notebooks)

- Tensorflow basics: https://www.tensorflow.org/guide/basics

- ReLU is a type of activation function. There several of these functions (ReLU, Sigmoid, tanh, ELU), but ReLU is used most commonly and serves as a good default. [more_on_relu](https://www.kaggle.com/dansbecker/rectified-linear-units-relu-in-deep-learning)

- Adam optimization : Adam is different to classical stochastic gradient descent. Adam is an optimization algorithm that can be used instead of the classical stochastic gradient descent procedure to update network weights iterative based in training data. [more_on_adam](https://machinelearningmastery.com/adam-optimization-algorithm-for-deep-learning/)

- Data set available at:
    - https://www.tensorflow.org/datasets/catalog/overview#all_datasets
    - https://github.com/zalandoresearch/fashion-mnist 

- Tutorials of udacity at: 
    - (lesson 3) https://colab.research.google.com/github/tensorflow/examples/blob/master/courses/udacity_intro_to_tensorflow_for_deep_learning/l03c01_classifying_images_of_clothing.ipynb#scrollTo=P7mUJVqcINSM
    - (lesson 2) https://colab.research.google.com/github/tensorflow/examples/blob/master/courses/udacity_intro_to_tensorflow_for_deep_learning/l02c01_celsius_to_fahrenheit.ipynb
    - (lesson 4) https://colab.research.google.com/github/tensorflow/examples/blob/master/courses/udacity_intro_to_tensorflow_for_deep_learning/l04c01_image_classification_with_cnns.ipynb

- Image normalization for image classification: https://machinelearningmastery.com/how-to-manually-scale-image-pixel-data-for-deep-learning/

- Difference between batch and epoch: The batch size is a number of samples processed before the model is updated. The number of epochs is the number of complete passes through the training dataset. The size of a batch must be more than or equal to one and less than or equal to the number of samples in the training dataset. [more_on_batchvsepoch](https://machinelearningmastery.com/difference-between-a-batch-and-an-epoch/)

- Regression: linear problem by regression , getting 1 output from 1 input

- Classification: non linear problem, each output has value via soft-max. Gives probability which sums to 1, one of the many output will be the higher value (confidence)

- Comprehensive guide to Convolutional Neural Network (CNN): https://towardsdatascience.com/a-comprehensive-guide-to-convolutional-neural-networks-the-eli5-way-3bd2b1164a53

