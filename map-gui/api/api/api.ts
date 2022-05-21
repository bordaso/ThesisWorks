export * from './basicErrorController.service';
import { BasicErrorControllerService } from './basicErrorController.service';
export * from './grpcTestRestController.service';
import { GrpcTestRestControllerService } from './grpcTestRestController.service';
export const APIS = [BasicErrorControllerService, GrpcTestRestControllerService];
