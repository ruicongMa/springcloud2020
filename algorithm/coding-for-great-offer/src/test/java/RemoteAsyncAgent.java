// import java.util.Objects;
// import java.util.concurrent.CompletableFuture;
// import java.util.concurrent.TimeUnit;
//
// /**
//  * @author Mark
//  * @date 2021/9/16 0:15
//  */
// public abstract class RemoteAsyncAgent<I,O> extends RemoteAgent<I, CompletableFuture<O>> {
//
//     public RemoteAsyncAgent() {
//     }
//
//     @Override
//     public CompletableFuture<O> execute(I input) throws Exception {
//         final long start = System.currentTimeMillis();
//         CompletableFuture<O> execute = super.execute(input);
//         if(Objects.isNull(execute)) {
//             execute = CompletableFuture.completedFuture(null);
//         }
//         return execute.thenApplyAsync(o -> {
//             logOnCallback(o, System.currentTimeMillis() - start);
//             return o;
//         });
//     }
//
//     public O getAsyncResult(CompletableFuture<O> future, Object logParam) throws Exception {
//         return getAsyncResult(future, logParam, getTimeout());
//     }
//
//     protected long getTimeout() {
//         return 5000;
//     }
//
//     public O getAsyncResult(CompletableFuture<O> future, Object logParam, long timeout) throws Exception {
//         long start = System.currentTimeMillis();
//         try {
//             O res = future.get(timeout, TimeUnit.MILLISECONDS);
//             logOnAsyncGet(res, System.currentTimeMillis() - start);
//             return res;
//         } catch (Exception e) {
//             logOnAsyncGetError(logParam, e, System.currentTimeMillis() - start);
//             throw e;
//         }
//     }
//
//     protected void logOnCallback(O res, long elapsed) {
//         LOGGER.info("agent invoke Future返回成功 interface = {}, res = {} elapsed = {}", key(), res , elapsed);
//     }
//
//     protected void logOnAsyncGet(O res, long elapsed) {
//         LOGGER.info("agent invoke 读取Future成功 interface = {}, res = {} elapsed = {}", key(), res, elapsed);
//     }
//
//     protected void logOnAsyncGetError(Object logParam, Exception e, long elapsed) {
//         LOGGER.error("agent invoke 读取Future失败! interface = {}, input = {}", key(), logParam, e);
//     }
// }
