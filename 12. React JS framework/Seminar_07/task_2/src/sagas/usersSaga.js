import { call, put, takeEvery } from 'redux-saga/effects';

// Функция для непосредственного запроса к API
function fetchUsersApi() {
  return fetch('https://jsonplaceholder.typicode.com/users')
    .then(response => {
      if (!response.ok) throw new Error('Ошибка сервера');
      return response.json();
    });
}

// Рабочая сага (Worker saga): выполняет асинхронную логику
function* fetchUsersWorker() {
  try {
    // call вызывает асинхронную функцию
    const users = yield call(fetchUsersApi); 
    // put отправляет экшен в редюсер (аналог dispatch)
    yield put({ type: 'FETCH_USERS_SUCCESS', payload: users });
  } catch (error) {
    yield put({ type: 'FETCH_USERS_FAILURE', payload: error.message });
  }
}

// Следящая сага (Watcher saga): перехватывает экшен FETCH_USERS_REQUEST
export default function* watchUsersSaga() {
  yield takeEvery('FETCH_USERS_REQUEST', fetchUsersWorker);
}
