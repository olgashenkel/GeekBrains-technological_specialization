import { createStore, applyMiddleware, combineReducers } from 'redux';
import createSagaMiddleware from 'redux-saga';
import usersReducer from './reducers/usersReducer'; 
import watchUsersSaga from './sagas/usersSaga';

const rootReducer = combineReducers({
  users: usersReducer 
});

const sagaMiddleware = createSagaMiddleware();

const store = createStore(
  rootReducer,
  applyMiddleware(sagaMiddleware)
);

sagaMiddleware.run(watchUsersSaga);

export default store;
