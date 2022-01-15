# (type A)training first gen CNN neural net on parabolic sar + bollinger 
```
historical purpose:
Type: computer vision CNN
Trading Pair: EURUSD
img_width, img_height = 566, 566
input_shape = (img_width, img_height, 3)
epochs = 20
batch_size = 7
nb_train_samples = 4313
nb_validation_samples = 1680 
```

## Type A 1st gen CNN update:
- trained model are inputted sample data from 2019 on EURUSD, the result are transformed into indicator and imported into metatrader terminal <br/>
-it seems the model did well to identify that a price would be going down as non-lagging(leading indicator), any radical movement to 0.00xx indicate a big short is incoming. The model are especially good at noticing a short opportunity more than long. However there are too much noise in the model chart to filter out redundant data <br/>
-Type A 1st gen gives interesting result, but work will stop here 🔴 . 
Next step is to decipher and reconstruct  this research paper : https://www.researchgate.net/publication/324802031_Algorithmic_Financial_Trading_with_Deep_Convolutional_Neural_Networks_Time_Series_to_Image_Conversion_Approach (CNN+LTSM model)  as Type B 1st Gen
