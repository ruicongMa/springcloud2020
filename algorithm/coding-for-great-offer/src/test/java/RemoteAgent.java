//
// /**
//  * @author Mark
//  * @date 2021/9/16 0:11
//  */
// public abstract class RemoteAgent<I, O> {
//
//     protected abstract String key();
//
//     protected abstract O invokeRemote(I input) throws Exception;
//
//     public O execute(I input) throws Exception {
//         try {
//             long start = System.currentTimeMillis();
//             O output = invokeRemote(input);
//             long elapsed = System.currentTimeMillis() - start;
//             if (output != null) {
//                 logOnRemote(input, elapsed, output);
//             } else {
//                 logOnRemoteMissing(input, elapsed);
//             }
//             return output;
//         } catch (Exception e) {
//             logOnRemoteError(input, e);
//             throw e;
//         }
//     }
//
//     protected void logOnRemote(I input, long elapsed, Object output) {
//         LOGGER.info("agent invoke 调用成功 interface = {}, input = {}, elapsed = {}", key(), input, elapsed);
//     }
//
//     protected void logOnRemoteMissing(I input, long elapsed) {
//         LOGGER.error("agent invoke 返回NULL! interface = {}, input = {}", key(), input);
//     }
//
//     protected void logOnRemoteError(I input, Throwable e) {
//         LOGGER.error("agent invoke 错误！ interface = {}, input = {}, e = {}", key(), input, e.getMessage(), e);
//     }
// }
