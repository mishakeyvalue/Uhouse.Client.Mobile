import { createStore } from 'redux'

import rootReducer from './rootReducer' 

const initialState = { timeBinds: [{id: 42, date: 42}]}

const store = createStore(rootReducer, initialState);

export default store;