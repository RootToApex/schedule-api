# 일정관리앱

### 일정 생성

| **Method** | **URL** | **인증** |
| --- | --- | --- |
| POST | `/api/schedules` | - |

**Headers**

- `Content-Type: application/json`

**Body**

```json
{
  "title": "일정 제목",
  "content": "일정 내용",
  "author": "작성자명",
  "password": "비밀번호"
}
```

**Response**

- `201 Created` (또는 `200 OK`)
    - `id`, `title`, `content`, `author`, `createdAt`

---

### 전체 일정 조회

| **Method** | **URL** | **인증** |
| --- | --- | --- |
| GET | `/api/schedules` | - |

**Response**

- `200 OK`
    - 일정 목록: `id`, `title`, `author`, `createdAt`, `updatedAt`

---

### 선택 일정 조회

| **Method** | **URL** | **인증** |
| --- | --- | --- |
| GET | `/api/schedules/{id}` | - |

**Path Parameters**

- `id`: 조회할 일정의 고유 번호

**Response**

- `200 OK`
    - `id`, `title`, `content`, `author`, `createdAt`, `updatedAt`
- `400 Bad Request`
    - 해당 ID가 없을 경우

---

### 일정 수정

| **Method** | **URL** | **인증** |
| --- | --- | --- |
| PATCH (또는 PUT) | `/api/schedules/{id}` | - |

**Path Parameters**

- `id`: 수정할 일정의 고유 번호

**Body**

```json
{
  "title": "수정할 제목",
  "content": "수정할 내용",
  "author": "수정할 작성자",
  "password": "기존 비밀번호"
}
```

**Response**

- `200 OK`
    - 수정된 일정의 `id` (또는 전체 데이터)
- `500 Internal Server Error`
    - 비밀번호 불일치 시 예외 발생

---

### 일정 삭제

| **Method** | **URL** | **인증** |
| --- | --- | --- |
| DELETE | `/api/schedules/{id}` | - |

**Path Parameters**

- `id`: 삭제할 일정의 고유 번호

**Query Parameters**

- `password`: 비밀번호

**Response**

- `200 OK` (또는 `204 No Content`)
    - 삭제된 일정의 `id`
- `500 Internal Server Error`
    - 비밀번호 불일치 시 예외 발생
