import { combineReducers } from 'redux'

import addItem from './AddItem/reducer'

export default combineReducers({
    timeBinds: addItem
});